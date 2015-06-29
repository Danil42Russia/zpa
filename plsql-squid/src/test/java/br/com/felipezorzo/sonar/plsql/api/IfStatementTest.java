package br.com.felipezorzo.sonar.plsql.api;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class IfStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.IF_STATEMENT);
    }

    @Test
    public void matchesSimpleIf() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithElsif() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithMultipleElsif() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithElse() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "else "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesIfWithElsifAndElse() {
        assertThat(p).matches(""
                + "if true then "
                + "null; "
                + "elsif true then "
                + "null; "
                + "else "
                + "null; "
                + "end if;");
    }
    
    @Test
    public void matchesNestedIf() {
        assertThat(p).matches(""
                + "if true then "
                + "if true then "
                + "null; "
                + "end if;"
                + "end if;");
    }

}