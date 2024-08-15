package com.jk.redis.integration.entity;


import lombok.Data;

import java.io.Serializable;


/**
 * @author Junaid Khan
 *
 */


@Data
public class User implements Serializable {


    private String userId;
    private String name;
    private String cellNo;
    private String email;


}
