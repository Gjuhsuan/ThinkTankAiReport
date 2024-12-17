package com.thinktank.service;

import com.thinktank.db.dao.proxy.DocumentDao;
import com.thinktank.db.factory.DaoFactory;
import com.thinktank.db.vo.Document;

public class DocumentService {
    private DocumentDao documentDaoProxy;

    public DocumentService() {
        documentDaoProxy = DaoFactory.createDocumentDao();
    }

    public Document getDocumentById(Integer id) {
        return documentDaoProxy.findById(id);
    }
}
