**[`JOIN` VS. `JOIN FETCH`](https://github.com/totemtec/Hibernate-JPA/tree/master/JoinVSJoinFetch)**

**See also:**
- [How To Avoid LazyInitializationException Via JOIN FETCH](https://github.com/totemtec/Hibernate-JPA/tree/master/JoinFetch)
- [LEFT JOIN FETCH](https://github.com/totemtec/Hibernate-JPA/tree/master/LeftJoinFetch)
     
**说明:** 本例子旨在对比 `JOIN` 和 `JOIN FETCH` 的不同. 要记住重要的是,
`LAZY` 懒加载模式下, 只用1次 `SELECT` ，`JOIN` 是无法初始化父对象里的子对象集合.
 而 `JOIN FETCH` 却能完成这个任务. 
 但是, 也不要小看 `JOIN`, 当一个查询要使用两表或者多表的字段, 但是返回的实体又不需要初始化关联集合时, `JOIN` 就是合适的选择 (例如, 获取 DTO 时就非常有用).

**要点:**
- 定义两个关联实体 (例如, `Author` 和 `Book` 是一对多的双向懒加载的关系)
- 使用 `JOIN` 和 `JOIN FETCH` 来获取作者以及他的书，在类 AuthorRepository 里面
- 使用 `JOIN` 来获取书 (1)，BookRepository 的 fetchBooksAuthorsInnerJoinBad 方法
- 使用 `JOIN` 来获取书包括作者 (2)，BookRepository 的 fetchBooksAuthorsInnerJoinGood 方法
- 使用 `JOIN FETCH` 来获取书包括它的作者，BookRepository 的 fetchBooksAuthorsJoinFetch 方法

**注意:**
- 通过 `JOIN`, 获取 `Author`后，读取 books，需要再次 `SELECT` 查询，会做n+1次查询
- 通过 `JOIN` (1), 来获取 `Book` ，如果要访问author，则需要再做 `SELECT` 查询，会做n+1次查询
- 通过 `JOIN` (2), 来获取 `Book` 后，访问 author 跟 `JOIN FETCH` 一样，仅需1次查询
- 通过 `JOIN FETCH`, 来获取 `Book`，访问 author 不需要再次查询，仅需1次查询
