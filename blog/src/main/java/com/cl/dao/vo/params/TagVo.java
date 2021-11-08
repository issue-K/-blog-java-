package com.cl.dao.vo.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagVo {

    private Long id;

    private String avatar;
    private String tagName;

}
