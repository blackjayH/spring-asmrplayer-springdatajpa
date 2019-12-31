package com.asmr.vo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAudioVO is a Querydsl query type for AudioVO
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAudioVO extends EntityPathBase<AudioVO> {

    private static final long serialVersionUID = -1388605116L;

    public static final QAudioVO audioVO = new QAudioVO("audioVO");

    public final NumberPath<Integer> musicnumber = createNumber("musicnumber", Integer.class);

    public final NumberPath<Integer> slot = createNumber("slot", Integer.class);

    public final NumberPath<Integer> track = createNumber("track", Integer.class);

    public final StringPath userid = createString("userid");

    public final NumberPath<Float> volume = createNumber("volume", Float.class);

    public QAudioVO(String variable) {
        super(AudioVO.class, forVariable(variable));
    }

    public QAudioVO(Path<? extends AudioVO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAudioVO(PathMetadata<?> metadata) {
        super(AudioVO.class, metadata);
    }

}

