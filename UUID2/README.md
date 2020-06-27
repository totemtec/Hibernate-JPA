**[使用Hibernate `uuid2` 自动生成ID](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootUUID2)**
 
**Description:** 

**要点:**
- 主键注解 @GenericGenerator(name = "uuid2", strategy = "uuid2")，生成的36位字符串，包含4个"-"
- 主键注解 @GeneratedValue(generator = "uuid2")
     
**备注：**
- 原文直接使用`BINARY(16)`存储UUID对象，实际操作中UUID二进制可读性太差了，里面还包含不可见字符
- 已改为VARCHAR(36)存储

------------------------------------------------------------------------------------------
原文及代码来自：

https://github.com/AnghelLeonard/Hibernate-SpringBoot

------------------------------------------------------------------------------------------
