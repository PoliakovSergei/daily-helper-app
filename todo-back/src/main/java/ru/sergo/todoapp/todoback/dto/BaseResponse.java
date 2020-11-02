package ru.sergo.todoapp.todoback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BaseResponse {
    public Object data;
}
