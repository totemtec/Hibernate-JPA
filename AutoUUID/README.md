**[使用JPA `jpa-uuid` 自动生成字符串ID](https://github.com/totemtec/Hibernate-JPA/tree/master/AutoUUID)**

**说明:**

**要点:**
- 主键注解 @GenericGenerator(name = "jpa-uuid", strategy = "uuid")，生成的32位字符串，不包含"-"
- 主键注解 @GeneratedValue(generator = "jpa-uuid")
     
**备注：**
- 原文直接使用`BINARY(16)`存储UUID对象，实际操作中UUID二进制可读性太差了，里面还包含不可见字符
- 已改为`VARCHAR(32)`存储字符串

------------------------------------------------------------------------------------------
原文及代码来自：

https://github.com/AnghelLeonard/Hibernate-SpringBoot

------------------------------------------------------------------------------------------
