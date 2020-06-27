**[自动生成UUID字符串ID](https://github.com/totemtec/Hibernate-JPA/tree/master/AutoUUID)**

**说明:** 使用JPA `@GenericGenerator` `@GeneratedValue` 自动生成UUID字符串ID.

**要点:**
- 实体类注解 @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
- 主键注解 @GeneratedValue(generator = "jpa-uuid")
     
**备注：**
- 原文直接使用`BINARY(16)`存储UUID对象，实际操作中UUID二进制可读性太差了，里面还包含不可见字符

------------------------------------------------------------------------------------------
原文及代码来自：

https://github.com/AnghelLeonard/Hibernate-SpringBoot

------------------------------------------------------------------------------------------
