package com.msw.moa.listener;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Hibernateイベントリスナー登録
 * 
 * @author 王磊
 */
@Component
public class HibernateEventWiring {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PersistListener persistListener;

	@Autowired
	private MergeListener mergeListener;

	@PostConstruct
	public void registerListeners() {
		EventListenerRegistry registry = ((SessionFactoryImpl)sessionFactory).getServiceRegistry().getService(EventListenerRegistry.class);
		// データ登録リスナー
		registry.getEventListenerGroup(EventType.PERSIST).prependListener(persistListener);
		// データ更新リスナー
		registry.getEventListenerGroup(EventType.MERGE).prependListener(mergeListener);
	}
}
