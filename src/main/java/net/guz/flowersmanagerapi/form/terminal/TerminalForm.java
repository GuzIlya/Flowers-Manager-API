package net.guz.flowersmanagerapi.form.terminal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalForm {
    private String login;
    private String password;
}
