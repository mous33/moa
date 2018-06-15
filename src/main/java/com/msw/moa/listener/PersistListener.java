package com.msw.moa.listener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultPersistEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.springframework.stereotype.Component;

import com.msw.moa.entity.AbstractEntity;
import com.msw.moa.json.common.LoginUser;
import com.msw.moa.utils.UserUtils;

/**
 * データ登録リスナー
 * 
 * @author 王磊
 */
@Component
public class PersistListener extends DefaultPersistEventListener {

	@SuppressWarnings("rawtypes")
	@Override
	public void onPersist(PersistEvent event, Map createCache) throws HibernateException {
		AbstractEntity entity = (AbstractEntity)event.getObject();
		LoginUser user = UserUtils.getLoginUser();
		if (user != null) {
			entity.setCreateUser(user.getUserId());
			entity.setUpdUser(user.getUserId());
		}
		Date d = new Date();
		entity.setCreateTimestamp(new Timestamp(d.getTime()));
		entity.setUpdateTimestamp(new Timestamp(d.getTime()));
		super.onPersist(event, createCache);
	}
}
