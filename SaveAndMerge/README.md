**[优化实体更新](https://github.com/totemtec/Hibernate-JPA/tree/master/SaveAndMerge)** 
 
**说明:** Spring Data `save()` 方法会调用 `EntityManager#persist()` 或 `EntityManager#merge()`. 在很多情形下，了解这个知识非常重要. 本例中, 我们是更新实体 (简单更新或者批量更新). 

 `Author` 和 `Book` 涉及双向懒加载 `@OneToMany` 关联。我们加载 `Author`, 拆解它, *detached* 状态下更新, 通过 `save()` 方法保存到数据库. 调用 `save()`, 背后会调用`merge()`, 造成下面两个问题:

- 会执行两个SQL语句, `SELECT` (merge) 和1个 `UPDATE`
- `SELECT` 还会 `LEFT OUTER JOIN` 来获取关联的 `Book` (这里我们不需要Book对象!)

怎么能只做 `UPDATE` 呢? 解决方案是调用 `Session#update()`. 调用 `Session.update()` 需要通过 `entityManager.unwrap(Session.class)` 来拿到 `Session` 对象 .

**要点:**
- `Session.update()` 只触发 `UPDATE` (不再查询 `SELECT`)
- `Session.update()` 还可以使用 *versioned* 乐观锁 (so, *lost updates* are prevented)


