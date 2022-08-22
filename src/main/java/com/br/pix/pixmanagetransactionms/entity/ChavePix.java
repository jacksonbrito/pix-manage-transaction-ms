package com.br.pix.pixmanagetransactionms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChavePix implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @CPF
    @Column(name = "chaveCPF")
    private String chaveCPF;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Email
    @Column(name = "chaveEmail")
    private String chaveEmail;
}
