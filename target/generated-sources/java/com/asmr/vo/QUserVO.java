package com.asmr.vo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserVO is a Querydsl query type for UserVO
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserVO extends EntityPathBase<UserVO> {

    private static final long serialVersionUID = -582398737L;

    public static final QUserVO userVO = new QUserVO("userVO");

    public final StringPath id = createString("id");

    public final StringPath pw = createString("pw");

    public QUserVO(String variable) {
        super(UserVO.class, forVariable(variable));
    }

    public QUserVO(Path<? extends UserVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserVO(PathMetadata<?> metadata) {
        super(UserVO.class, metadata);
    }

}

