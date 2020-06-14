package net.guz.flowersmanagerapi.form.terminal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private Long id;
    private String date;
    private String time;
    private String address;
    private String customer;
}
