# 备忘录模式（Memento Pattern）

## 设计模式简介

备忘录模式是一种行为型设计模式，它在不破坏封装性的前提下，捕获并保存一个对象的内部状态，以便之后恢复到某个历史状态。  
这个模式特别适合“存档”“回档”“撤销”“快照”之类的业务场景。

当前示例中，`HeroRole` 表示游戏角色，`GameMemento` 负责保存角色关键状态，`SaveManager` 则管理多个存档。

## 核心角色

### 1. 发起人（Originator）
负责创建备忘录并根据备忘录恢复状态。示例中的 `HeroRole` 就是发起人。

### 2. 备忘录（Memento）
用于保存发起人的状态快照。示例中的 `GameMemento` 保存了等级、生命值、蓝量、金币和存档时间。

### 3. 管理者（Caretaker）
负责保存和读取备忘录，但不操作备忘录内部细节。示例中的 `SaveManager` 就是管理者。

### 4. 客户端（Client）
负责触发保存和恢复。示例中的 `MementoTest` 演示了存档与回档过程。

## 实现方式

### 1. 发起人生成快照
```java
public GameMemento saveState() {
    return new GameMemento(level, hp, mp, score);
}
```

### 2. 发起人根据快照恢复状态
```java
public void restoreState(GameMemento memento) {
    this.level = memento.getLevel();
    this.hp = memento.getLives();
    this.mp = memento.getBlue();
    this.score = memento.getScore();
}
```

### 3. 管理者统一保存多个存档
```java
public void save(String name, GameMemento gameMemento) {
    saveMap.computeIfAbsent(name, key -> new ArrayList<>()).add(gameMemento);
}
```

## 实现特点

### 优点
1. **支持状态回滚**：可以方便恢复到之前某个时间点。
2. **不破坏封装**：外部不需要直接访问对象内部细节。
3. **适合快照场景**：如游戏存档、编辑器撤销、流程回退等。
4. **状态管理清晰**：将对象当前状态和历史状态分开管理。

### 缺点
1. **内存开销可能较大**：如果状态很多、快照很多，会占用较多资源。
2. **状态字段变化时需同步维护**：发起人和备忘录需要保持一致。
3. **管理复杂度增加**：存档数量多时，需要额外考虑命名、索引和清理策略。

### 适用场景
- 游戏存档与读档
- 编辑器撤销与恢复
- 表单、流程、任务的阶段快照
- 需要保留历史状态但又不想暴露内部结构的场景

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/behavioral/mementoParttern/*.java
java com.pengli.designPattern.behavioral.mementoParttern.MementoTest
```

### 输出示例
```text
Hero: Hero level: 1 exp: 0 score: 0 hp: 100 mp: 100 attack: 10 defense: 10 magic: 10 speed: 10
Hero: Hero level: 2 exp: 100 score: 0 hp: 200 mp: 100 attack: 10 defense: 10 magic: 10 speed: 10
Hero: Hero level: 1 exp: 100 score: 0 hp: 100 mp: 100 attack: 10 defense: 10 magic: 10 speed: 10
Hero: Hero level: 2 exp: 100 score: 0 hp: 200 mp: 100 attack: 10 defense: 10 magic: 10 speed: 10
```

说明：当前示例恢复的是 `level`、`hp`、`mp`、`score`，像 `exp` 等字段没有被保存在 `GameMemento` 中，因此恢复后不会回滚这些字段。

## 关键代码说明

### `HeroRole`
- 当前业务对象，保存游戏角色完整状态
- `saveState()` 负责创建快照
- `restoreState()` 负责从快照恢复状态

### `GameMemento`
- 只保存需要恢复的关键字段
- 当前示例还记录了 `timeStamp`，便于表示存档时间

### `SaveManager`
- 使用 `Map<String, List<GameMemento>>` 管理多个存档槽位
- 支持按名称与索引加载存档

### `MementoTest`
- 演示角色升级、加经验、保存存档
- 再从不同存档位置恢复状态

## 设计模式对比

| 模式 | 关注点 | 是否保存历史状态 | 典型场景 |
|------|------|----------------|---------|
| 备忘录模式 | 状态快照与恢复 | 是 | 游戏存档、撤销 |
| 命令模式 | 请求封装与撤销 | 可结合实现 | 撤销操作 |
| 状态模式 | 状态驱动行为切换 | 否 | 状态机 |

## 示例总结

这个示例很适合用来理解备忘录模式：
- `HeroRole` 是需要被回档的对象
- `GameMemento` 是状态快照
- `SaveManager` 统一管理多个历史快照

通过这三个角色配合，就能把“对象当前状态”和“对象历史状态”清晰分离出来。
