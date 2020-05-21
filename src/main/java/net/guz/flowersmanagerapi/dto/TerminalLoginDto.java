package net.guz.flowersmanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TerminalLoginDto {
    private String login;
    private String password;
}
