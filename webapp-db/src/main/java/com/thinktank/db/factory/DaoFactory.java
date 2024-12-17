package com.thinktank.db.factory;

import com.thinktank.db.dao.proxy.DocumentDao;
import com.thinktank.db.dao.proxy.UserDao;
import com.thinktank.db.dao.proxy.impl.DocumentDaoImpl;
import com.thinktank.db.dao.proxy.impl.UserDaoImpl;

public class DaoFactory {
    public static DocumentDao createDocumentDao() {
        return new DocumentDaoImpl();
    }
    
    public static UserDao createUserDao() {
        return new UserDaoImpl();
    }
} 