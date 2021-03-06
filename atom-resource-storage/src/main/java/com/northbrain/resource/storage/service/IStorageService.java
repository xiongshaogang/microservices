package com.northbrain.resource.storage.service;

import java.util.List;

import com.northbrain.base.common.model.vo.basic.ServiceVO;
import com.northbrain.base.common.model.vo.atom.StorageVO;

/**
 * 类名：存储服务接口
 * 用途：封装存储信息等Domain，管理事务，并封装ServiceVO
 * @author Jiakun
 * @version 1.0
 */
public interface IStorageService
{
    /**
     * 方法：获取特定的存储信息
     * @param storageId 存储编号
     * @return ServiceVO封装类
     */
    ServiceVO readStorage(int storageId);

    /**
     * 方法：获取一组指定资源ID的资源信息
     * @param storageIds 一组资源的ID集合
     * @return ServiceVO封装类，封装了选出的存储信息的集合
     */
    ServiceVO readStorages(List<Integer> storageIds);

    /**
     * 方法：创建一条存储资源
     * @param storageVO 存储资源值对象
     * @return 是否操作成功（用ServiceVO封装）
     */
    ServiceVO createStorage(StorageVO storageVO);

    /**
     * 方法：更新一条存储资源
     * @param storageVO 存储资源值对象
     * @return 是否操作成功（用ServiceVO封装）
     */
    ServiceVO updateStorage(StorageVO storageVO);

    /**
     * 方法：删除一条存储资源
     * @param storageVO 存储资源值对象
     * @return 是否操作成功（用ServiceVO封装）
     */
    ServiceVO deleteStorage(StorageVO storageVO);
}
