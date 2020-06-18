package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>${table.comment!} 服务类</p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * <p>查询${table.comment!}分页数据</p>
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<${entity}>
     */
    IPage<${entity}> findListByPage(Integer page, Integer pageCount);

    /**
     * <p>添加${table.comment!}</p>
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     */
    int add(${entity} ${entity?uncap_first});

    /**
     * <p>删除${table.comment!}</p>
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * <p>修改${table.comment!}</p>
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return int
     */
    int updateData(${entity} ${entity?uncap_first});

    /**
     * <p>id查询数据</p>
     *
     * @param id id
     * @return ${entity}
     */
    ${entity} findById(Long id);
}
</#if>
