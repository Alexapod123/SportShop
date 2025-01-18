package com.example.onlineShop.controller.utility;

import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.model.responseEnt.AdminResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UtilController {
    public boolean checkInput(Model model, AdminResponse adminResponse, String key, Object value) {
        if (adminResponse.getResponse().contains("success")) {
            model.addAttribute(adminResponse.getResponse(), adminResponse.getTextMessage());
            model.addAttribute(key, value);
            return true;
        }
        return false;
    }

    public boolean checkInputs(BindingResult result, Model model, String key, Object value) {
        if (result.hasErrors()) {
            model.mergeAttributes(getErrors(result));
            model.addAttribute(key, value);
            return true;
        }
        return false;
    }

    private Map<String, String> getErrors(BindingResult result) {
        Collector<FieldError, ?, Map<String, String>> mapCollector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        return result.getFieldErrors().stream().collect(mapCollector);
    }

    private int[] generatePagination(Page<?> page) {
        Integer totalPages = page.getTotalPages();
        if (totalPages > 7) {
            Integer numberPage = page.getNumber() + 1;
            Integer[] begin = numberPage > 4 ? new Integer[]{1, -1} : new Integer[]{1, 2, 3};
            Integer[] end = numberPage < (totalPages - 3) ? new Integer[]{-1, totalPages} : new Integer[]{totalPages - 2, totalPages - 1, totalPages};
            Integer[] middleBegin = (numberPage > 4 && numberPage < (totalPages - 1)) ? new Integer[]{numberPage - 2, numberPage - 1} : new Integer[]{};
            Integer[] middleEnd = (numberPage > 2 && numberPage < (totalPages - 3)) ? new Integer[]{numberPage + 1, numberPage + 2} : new Integer[]{};

            List<Integer> pagination = new ArrayList<>();
            Collections.addAll(pagination, begin);
            Collections.addAll(pagination, middleBegin);
            Collections.addAll(pagination, middleEnd);
            Collections.addAll(pagination, end);
            Integer[] arrayPag = pagination.toArray(new Integer[0]);
            return Arrays.stream(arrayPag).mapToInt(Integer::intValue).toArray();
        } else return IntStream.rangeClosed(1, totalPages).toArray();
    }

    public <T> void addPagination(Model model, Page<T> page) {
        model.addAttribute("pagination", generatePagination(page));
        model.addAttribute("page", page);
    }

    public <T> void addPagination(SearchRequest request, Model model, Page<T> page) {
        model.addAttribute("searchRequest", request);
        addPagination(model, page);
    }

    public String setAlertMsg(Model model, String page, AdminResponse adminResponse) {
        model.addAttribute("messageType", adminResponse.getResponse());
        model.addAttribute("message", adminResponse.getTextMessage());
        return page;
    }

    public String setFlashMsg(RedirectAttributes redirectAttributes, String page, AdminResponse adminResponse) {
        redirectAttributes.addFlashAttribute("messageType", adminResponse.getResponse());
        redirectAttributes.addFlashAttribute("message", adminResponse.getTextMessage());
        return page;
    }
}
