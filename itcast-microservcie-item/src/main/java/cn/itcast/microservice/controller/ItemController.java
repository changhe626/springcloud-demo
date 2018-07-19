package cn.itcast.microservice.controller;

import cn.itcast.microservice.config.JdbcConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.microservice.pojo.Item;
import cn.itcast.microservice.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private JdbcConfigBean jdbcConfigBean;

	/**
	 * 对外提供接口服务，查询商品信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "item/{id}")
	public Item queryItemById(@PathVariable("id") Long id) {
		System.out.println(111);
		return itemService.queryItemById(id);
	}


    /**
     * 测试是否能够去得到值
     * @return
     */
	@GetMapping("test")
    public String test(){
	    return jdbcConfigBean.toString();
    }


}
