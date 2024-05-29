package com.keyin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine = new SuggestionEngine();

    @Mock
    private SuggestionsDatabase mockSuggestionDB;
    private boolean testInstanceSame = false;

    @Test
    public void testCorrectWord() throws Exception {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get("path/to/dictionary/words.txt"));
        String word = "example";
        String suggestions = suggestionEngine.generateSuggestions(word);
        assertEquals("", suggestions);
    }


    @Test
    public void testSingleCharacterMistake() throws Exception {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get("path/to/dictionary/words.txt"));
        String word = "exampel";
        String suggestions = suggestionEngine.generateSuggestions(word);
        assertTrue(suggestions.contains("example"));
    }



    @Test
    public void testCompletelyIncorrectWord() throws Exception {
        SuggestionEngine suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get("path/to/dictionary/words.txt"));
        String word = "xmplae";
        String suggestions = suggestionEngine.generateSuggestions(word);
        assertTrue(suggestions.contains("example"));
    }


