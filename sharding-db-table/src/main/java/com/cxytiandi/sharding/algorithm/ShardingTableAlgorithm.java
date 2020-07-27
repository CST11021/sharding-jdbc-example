package com.cxytiandi.sharding.algorithm;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * 自定义分片算法
 * 
 * @author yinjihuan
 *
 */
public class ShardingTableAlgorithm implements PreciseShardingAlgorithm<Long> {

	/**
	 * 根据分表字段获取要操作的分表的表名
	 *
	 * @param availableTargetNames		表示所有的分表的表名
	 * @param shardingValue				表示分表字段的值，一般为表的主键
	 * @return
	 */
	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		// 遍历素有的分表，找到对应的要操作的表，然后返回表名
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}

}
