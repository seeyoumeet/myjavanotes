package com.seeyoumeet.web.JdbcTemplate.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author : yuc5015
 * @Date : 2021/8/5
 * @Description :
 * @Modified By :
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User类对象", description="")
@TableName(value = "user")
public class User extends Model<User> {

    @ApiModelProperty(value = "主键")
    @TableId("ID")
    private Long id;

    @ApiModelProperty(value = "用户昵称")
    @TableField("nickname")
    private String nickname;

    @ApiModelProperty(value = "年龄")
    @TableField(value = "age", exist = false)
    private Integer age;

    @ApiModelProperty(value = "用户姓名")
    @TableField(value = "name", exist = false)
    private String name;

    @ApiModelProperty(value = "用户账号")
    @TableField(value = "account", exist = false)
    private String account;

    @ApiModelProperty(value = "用户邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "手机号")
    @TableField(value = "telephone", exist = false)
    private String telephone;

    @ApiModelProperty(value = "用户密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "用户头像")
    @TableField("avatar")
    private String avatar;
}
