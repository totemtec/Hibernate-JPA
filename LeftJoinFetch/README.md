**[`LEFT JOIN FETCH`](https://github.com/totemtec/Hibernate-JPA/tree/master/LeftJoinFetch)**

**See also:**
- [通过 JOIN FETCH 解决 LazyInitializationException 问题](https://github.com/totemtec/Hibernate-JPA/tree/master/JoinFetch)
- [JOIN VS. JOIN FETCH](https://github.com/totemtec/Hibernate-JPA/tree/master/JoinVSJoinFetch)

**说明:** 
假设我们有两个实体是1对多(或多对多)的双向(或单向)懒加载关系(例如 `Author` 有多个 `Book`),
然后我们想要一个 `SELECT` 就获取所有的 `Author` 及其相应的 `Book`. 
`JOIN FETCH` 会把查询转换为 `INNER JOIN`. 结果仅返回有 `Book` 的 `Author`.
如果想要所有的 `Author`, 包括那些没有 `Book` 的 `Author`, 我们就得用 `LEFT JOIN FETCH`. 
不同的是，我们要获取所有 `Book`, 包括没有登记 `Author` 的 `Book`, 使用 `JOIN FETCH` 也可以实现. 但是 `JOIN` 不行的，这里原文有错误

**要点:**
- 定义两个关联实体 (例如, `Author` 和 `Book` 是一对多的懒加载双向关系)
- 使用 `LEFT JOIN FETCH` 获取所有作者和他的书 (即使这些作者可能没有书)
- 使用 `LEFT JOIN FETCH` 获取所有书和它的作者 (即使这些书还没登记作者)

