/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * 使用插件就要实现{@link}接口
 * 模板模式提供一个骨架
 * @author Clinton Begin
 */
public interface Interceptor {

  /**
   * 覆盖拦截对象的所有方法
   * 通过Invocation反射调度原来对象的方法
   * */
  Object intercept(Invocation invocation) throws Throwable;

  /**
   * 生成代理对象
   * */
  default Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  /**
   * 允许在plugin中配置所需参数 方法在插件初始化的时候就被吊用一次
   * */
  default void setProperties(Properties properties) {
    // NOP
  }

}
