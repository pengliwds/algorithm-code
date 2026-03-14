# 组合模式（Composite Pattern）

## 设计模式简介

组合模式是一种结构型设计模式，它将对象组织成树形结构，以表示“整体 - 部分”的层次关系。  
通过组合模式，客户端可以用一致的方式对待单个对象和组合对象。

当前示例中，部门 `Department` 和员工 `Employee` 都实现了统一接口 `OrganizationComponent`，从而可以把公司组织结构表示为一棵树。

## 核心角色

### 1. 组件接口（Component）
定义叶子对象和组合对象的统一行为。示例中的 `OrganizationComponent` 就是组件接口。

### 2. 叶子节点（Leaf）
表示树结构中的最底层对象。示例中的 `Employee` 是叶子节点。

### 3. 容器节点（Composite）
表示可以包含子节点的组合对象。示例中的 `Department` 是容器节点。

### 4. 客户端（Client）
使用统一接口操作树形结构。示例中的 `ComponentPatternTest` 创建组织树并输出层级和成本。

## 实现方式

### 1. 定义统一组件接口
```java
public interface OrganizationComponent {
    String getName();
    String getRole();
    void showDetail(String indent);
    void add(OrganizationComponent organizationComponent);
    void remove(OrganizationComponent organizationComponent);
    double getCost();
}
```

### 2. 叶子节点实现基础行为
```java
public class Employee implements OrganizationComponent {
    @Override
    public double getCost() {
        return salary;
    }
}
```

### 3. 组合节点递归管理子节点
```java
public class Department implements OrganizationComponent {
    private List<OrganizationComponent> members = new ArrayList<>();

    @Override
    public double getCost() {
        double cost = 0;
        for (OrganizationComponent member : members) {
            cost += member.getCost();
        }
        return cost;
    }
}
```

## 实现特点

### 优点
1. **统一处理单个对象和组合对象**：客户端调用方式一致。
2. **天然适合树形结构**：如组织架构、文件系统、菜单、评论树等。
3. **便于递归处理**：统计、展示、遍历都很自然。
4. **扩展性较好**：新增节点类型时可以继续实现统一接口。

### 缺点
1. **接口可能偏宽**：叶子节点通常不需要 `add/remove`，但为了统一接口仍要实现。
2. **结构设计要求清晰**：树形层级复杂时，维护成本会上升。
3. **可能弱化类型约束**：客户端容易在不合适的节点上调用不适用的方法。

### 适用场景
- 公司组织架构
- 文件与文件夹结构
- 菜单与子菜单
- 树形评论、分类目录

## 运行示例

编译和运行：
```bash
javac -d . src/com/pengli/designPattern/structural/componentPattern/*.java
java com.pengli.designPattern.structural.componentPattern.ComponentPatternTest
```

### 输出示例
```text
Department: Company
--Department: DevOps
----Department: Java
------Employee: John, Role: Java Developer, Salary: 50000.0
------Employee: Jane, Role: Manager, Salary: 60000.0
----Employee: Tom, Role: CEO, Salary: 80000.0
--Department: 行政管理
----Employee: Mike, Role: Marketing, Salary: 40000.0
----Employee: Lisa, Role: HR, Salary: 30000.0
Total cost: 260000.0
```

## 关键代码说明

### `OrganizationComponent`
- 定义统一组件行为
- 让部门和员工都能以相同方式被操作

### `Employee`
- 叶子节点
- 没有子节点，因此 `add/remove` 不执行具体操作
- `getCost()` 直接返回工资

### `Department`
- 组合节点
- 可以继续包含部门或员工
- `showDetail()` 和 `getCost()` 都通过递归处理子节点

### `ComponentPatternTest`
- 构建组织树
- 展示树形结构
- 统计整个公司及局部部门的人力成本

## 设计模式对比

| 模式 | 主要目的 | 是否树形结构 | 典型对象 |
|------|---------|-------------|---------|
| 组合模式 | 统一处理整体和部分 | 是 | 部门/员工、文件夹/文件 |
| 装饰器模式 | 动态增强对象功能 | 否 | 组件包装 |
| 外观模式 | 统一对子系统入口 | 否 | 子系统整合 |

## 示例总结

这个示例将“部门”和“员工”统一抽象成组织组件：
- 部门可以继续包含子部门和员工
- 员工是最底层叶子节点
- 客户端可以统一地展示和统计整棵组织树

这正是组合模式最典型的使用方式。
