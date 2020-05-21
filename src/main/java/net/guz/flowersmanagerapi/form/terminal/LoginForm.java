package net.guz.flowersmanagerapi.form.terminal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
    private String terminalLogin;
    private String terminalPassword;
    private String floristPassword;
}
