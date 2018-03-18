package org.pitrecki.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.pitrecki.config.MockitoExtension;
import org.pitrecki.service.PersonDetailsGeneratorServiceImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Answers.CALLS_REAL_METHODS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Piotr 'pitrecki' Nowak
 *
 */
@ExtendWith(MockitoExtension.class)
class PersonControllerTest
{
    private static final String URI_REQUEST = "/api/people_data";
    private static final String SIZE = "5";
    private static final String EXPECTED_NON_PARAM_SIZE = "1";

    @Mock(answer = CALLS_REAL_METHODS)
    private PersonDetailsGeneratorServiceImpl generatorServiceMock;

    private MockMvc mockMvc;
    private PersonController sut;

    @BeforeEach
    void setUp() {
        this.sut = new PersonController(generatorServiceMock);
        this.mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
    }

    @Test
    @DisplayName("should return status ok")
    void testGeneratePersonsDataShouldReturnStatusOK() throws Exception {
        mockMvc.perform(get(URI_REQUEST)
            .param("amount", SIZE))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("should return JSON with expected size")
    void testGeneratePersonsDataShouldReturnJSONWithExpectedSize() throws Exception {
        mockMvc.perform(get(URI_REQUEST)
            .param("amount", SIZE))
            .andDo(print())
            .andExpect(jsonPath("$.length()").value(SIZE));
    }

    @Test
    @DisplayName("should retun JSON with one person when param amount not present")
    void testGeneratePersonsDataWithoutParamShouldReturnOnePerson() throws Exception {
        mockMvc.perform(get(URI_REQUEST))
            .andDo(print())
            .andExpect(jsonPath("$.length()").value(EXPECTED_NON_PARAM_SIZE));
    }
}                                                               ;