**[在 `@OneToOne` 关系中使用 `@MapsId` 共享ID主键](https://github.com/totemtec/Hibernate-JPA/tree/master/OneToOneMapsId)**

**说明:** 
相比常规的 `@OneToOne`, 单向地使用 `@OneToOne` 和 `@MapsId` 更好用. 

**要点:**
- 在子对象里使用 `@MapsId`
- 使用 `@JoinColumn` 来定制外键名
- 重点是, 对于 `@OneToOne` 关联, `@MapsId` 会与主表共享主键 (`id` 字段既是主键又是外键)    
     
**注意:**
- `@MapsId` 也被用于 `@ManyToOne`
- 谨慎使用，Book表的id字段不起作用了，而author_id当主键使用，得有人保证唯一性，容易出错，而且查询时必须先查询Author才能去拿Book

