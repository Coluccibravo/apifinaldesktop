package com.example.teste.Controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private static final String UPLOAD_DIR = "uploads";
    private final Path uploadPath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();

    public UploadController() throws IOException {
        try {
            Files.createDirectories(this.uploadPath);
        } catch (IOException e) {
            throw new IOException("Não foi possível criar o diretório de uploads.", e);
        }
    }

    @PostMapping("/imagem")
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile file,
                                             @RequestParam("username") String username) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Por favor, selecione um arquivo para upload.");
        }

        try {
            String originalName = file.getOriginalFilename();
            String ext = Optional.ofNullable(originalName)
                                 .filter(f -> f.contains("."))
                                 .map(f -> f.substring(f.lastIndexOf(".")))
                                 .orElse("");

            Path filePath = this.uploadPath.resolve(username + ext);
            file.transferTo(filePath.toFile());

            return ResponseEntity.status(HttpStatus.CREATED).body("/" + UPLOAD_DIR + "/" + username + ext);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    @GetMapping("/imagem/{username}")
    public ResponseEntity<Resource> imagemUsuario(@PathVariable String username) {
        try {
            // Achar o primeiro arquivo que comece com o nome de usuário (ex: gabriel.jpg)
            Path userImagePath = Files.list(this.uploadPath)
                                      .filter(path -> path.getFileName().toString().startsWith(username + "."))
                                      .findFirst()
                                      .orElse(null);

            if (userImagePath == null) {
                return ResponseEntity.notFound().build();
            }

            Resource resource = new UrlResource(userImagePath.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            String contentType = Files.probeContentType(userImagePath);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}