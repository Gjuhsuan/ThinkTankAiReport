package com.thinktank.service;

import com.thinktank.db.dao.proxy.DocumentDaoProxy;
import com.thinktank.db.vo.Document;
public class DocumentService {
    private DocumentDaoProxy documentDaoProxy;

    public DocumentService() {
        documentDaoProxy = new DocumentDaoProxy(); // TODO: 工厂类
    }

    public Document getDocumentById(int id) {
        return documentDaoProxy.getDocumentById(id);
    }
}
