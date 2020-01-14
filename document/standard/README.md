## 记录一些文档笔记
#### [@RequestParam和@PathVariable的用法与区别](https://blog.csdn.net/a15028596338/article/details/84976223)
- @RequestParam和@PathVariable都能够完成类似的功能——因为本质上，它们都是用户的输入，只不过输入的部分不同，一个在URL路径部分，另一个在参数部分。要访问一篇博客文章，这两种URL设计都是可以的：
  - 通过@PathVariable，例如/blogs/1
  - 通过@RequestParam，例如blogs?blogId=1
- 那么究竟应该选择哪一种呢？建议：
  - 当URL指向的是某一具体业务资源（或资源列表），例如博客，用户时，使用@PathVariable 
  - 当URL需要对资源或者资源列表进行过滤，筛选时，用@RequestParam
  - 例如我们会这样设计URL：
      - /blogs/{blogId}
      - /blogs?state=publish而不是/blogs/state/publish来表示处于发布状态的博客文章
      
  