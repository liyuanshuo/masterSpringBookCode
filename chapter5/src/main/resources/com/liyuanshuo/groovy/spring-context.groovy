import com.liyuanshuo.groovy.LogDao
import com.liyuanshuo.groovy.DbUserDao
import com.liyuanshuo.groovy.LogonService
import com.liyuanshuo.groovy.XmlUserDao
import org.springframework.core.io.ClassPathResource

beans {
    xmlns context: "http://www.springframework.org/schema/context"    //导入命名空间

    context.'component-scan'('base-package': "com.liyuanshuo.groovy") {
        'exclude-filter'('type': "aspectj", 'expression': "com.liyuanshuo.xml.*")
    }

    def stream
    def config = new Properties()
    try{
        stream = new ClassPathResource('conf/app-conf.properties').inputStream
        config.load(stream)
    }finally {
        if(stream!=null)
        stream.close()
    }

    if( config.get("dataProvider") == "db"){
        userDao(DbUserDao)
    }else{
        userDao(XmlUserDao)
    }

    logDao(LogDao){
        bean->
            bean.scope = "prototype"
            bean.initMethod="init"
            bean.destroyMethod="destroy"
            bean.lazyInit =true
    }

    logonService(LogonService,userDao){
        logDao = ref("logDao")
        mailService = ref("mailService")
    }

}