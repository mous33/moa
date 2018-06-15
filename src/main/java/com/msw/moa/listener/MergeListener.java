package com.msw.moa.listener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultMergeEventListener;
import org.hibernate.event.spi.MergeEvent;
import org.springframework.stereotype.Component;

import com.msw.moa.entity.AbstractEntity;
import com.msw.moa.json.common.LoginUser;
import com.msw.moa.utils.UserUtils;

/**
 * データ更新リスナー
 * 
 * @author 王磊
 */
@Component
public class MergeListener extends DefaultMergeEventListener {

	@SuppressWarnings("rawtypes")
	@Override
	public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {
		AbstractEntity entity = (AbstractEntity)event.getOriginal();
		LoginUser user = UserUtils.getLoginUser();
		if (user != null) {
			if (entity.getCreateUser() == null) {
				entity.setCreateUser(user.getUserId());
			}
			entity.setUpdUser(user.getUserId());
		}
		Date d = new Date();
		if (entity.getCreateTimestamp() == null) {
			entity.setCreateTimestamp(new Timestamp(d.getTime()));
		}
		entity.setUpdateTimestamp(new Timestamp(d.getTime()));

		super.onMerge(event, copiedAlready);
	}
}
