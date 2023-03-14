package com.dipak.userservice.DTO;

import com.dipak.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateDTO {

    private Users user;
    private Department department;
}
