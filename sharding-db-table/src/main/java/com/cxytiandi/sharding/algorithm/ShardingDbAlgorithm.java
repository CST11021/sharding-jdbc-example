package com.cxytiandi.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Author: wanghz
 * @Date: 2020/7/27 12:14 PM
 */
public class ShardingDbAlgorithm implements PreciseShardingAlgorithm<Long> {

    /**
     * 根据分表字段获取要操作的分库的库名
     *
     * @param collection		    表示所有的分库的库名
     * @param preciseShardingValue	表示分表字段的值，一般为表的主键
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        // 遍历素有的分库，找到对应的要操作的库，然后返回库名
        for (String dbName : collection) {
            if (dbName.endsWith(preciseShardingValue.getValue() % 2 + "")) {
                return dbName;
            }
        }
        throw new IllegalArgumentException();
    }

}
