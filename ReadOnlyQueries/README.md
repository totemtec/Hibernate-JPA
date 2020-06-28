**[Use Read-Only Entity Whenever You Plan To Propagate Entity Changes To The Database In A Future Persistent Context](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootReadOnlyQueries)**
 
**说明:**
本实例强调 加载实体时 *read-write* vs. *read-only* 的不同。
如果你打算在未来的持久化上下文里修改实体，那就用 *read-only* 来加载实体

**要点:**
- 在当前持久化上下文, 用 *read-only* 模式加载实体 
- modifiy the entities in the current Persistent Context or in detached state (the potential modifications done in the current Persistent Context will not be propagated to the database at flush time)
- 在后续的持久化上下文中，合并分离的实体并将更改传播到数据库

**Note:** 
如果你不打算修改数据，那就使用DTO (例如, Spring projection), 而不是使用 *read-only* 实体.
