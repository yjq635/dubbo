/*
 * Copyright 1999-2101 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.rpc.cluster;

import java.util.List;

import com.alibaba.dubbo.common.Extension;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;

/**
 * LoadBalance. (SPI, Singleton, ThreadSafe)
 * 
 * <a href="http://en.wikipedia.org/wiki/Load_balancing_(computing)">Load-Balancing</a>
 * 
 * @see com.alibaba.dubbo.rpc.cluster.Cluster#merge(Directory)
 * @author qian.lei
 * @author william.liangf
 */
@Extension(RandomLoadBalance.NAME)
public interface LoadBalance {

	/**
	 * select one invoker in list.
	 * 
	 * @param invokers invokers.
	 * @param invocation invocation.
	 * @return selected invoker.
	 */
	<T> Invoker<T> select(List<Invoker<T>> invokers, Invocation invocation) throws RpcException;

}