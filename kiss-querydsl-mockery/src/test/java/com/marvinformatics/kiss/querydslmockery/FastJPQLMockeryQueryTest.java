package com.marvinformatics.kiss.querydslmockery;

public class FastJPQLMockeryQueryTest extends AbstractJPQLMockeryQueryTest {

	@Override
	protected JPQLMockeryQuery createJPQLMockeryQuery() {
		return new FastJPQLMockeryQuery();
	}

}
