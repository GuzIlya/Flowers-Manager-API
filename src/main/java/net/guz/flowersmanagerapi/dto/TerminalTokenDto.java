package net.guz.flowersmanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TerminalTokenDto {
    private String token;

    public static TerminalTokenDto from(String token) {
        return new TerminalTokenDto(token);
    }
}
