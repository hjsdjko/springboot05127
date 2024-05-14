package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XiangmutijiaoDao;
import com.entity.XiangmutijiaoEntity;
import com.service.XiangmutijiaoService;
import com.entity.vo.XiangmutijiaoVO;
import com.entity.view.XiangmutijiaoView;

@Service("xiangmutijiaoService")
public class XiangmutijiaoServiceImpl extends ServiceImpl<XiangmutijiaoDao, XiangmutijiaoEntity> implements XiangmutijiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiangmutijiaoEntity> page = this.selectPage(
                new Query<XiangmutijiaoEntity>(params).getPage(),
                new EntityWrapper<XiangmutijiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiangmutijiaoEntity> wrapper) {
		  Page<XiangmutijiaoView> page =new Query<XiangmutijiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiangmutijiaoVO> selectListVO(Wrapper<XiangmutijiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiangmutijiaoVO selectVO(Wrapper<XiangmutijiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiangmutijiaoView> selectListView(Wrapper<XiangmutijiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiangmutijiaoView selectView(Wrapper<XiangmutijiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
