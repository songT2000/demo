package com.demo.portal.test.protocoltcp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageProtocol implements Serializable {

    private static final transient long serialVersionUID = 1L;

    private int len;
    private byte[] content;

}
