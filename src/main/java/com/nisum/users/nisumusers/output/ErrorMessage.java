package com.nisum.users.nisumusers.output;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private static final long serialVersionUID = 1L;
    private String mensaje;
}
