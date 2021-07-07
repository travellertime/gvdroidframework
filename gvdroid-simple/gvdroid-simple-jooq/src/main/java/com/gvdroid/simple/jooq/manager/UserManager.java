package com.gvdroid.simple.jooq.manager;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManager {

    final DSLContext dslContext;

}
