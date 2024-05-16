//package com.example.ceramicjbw.service.Category;
//
//import com.example.ceramicjbw.entity.CategoryHealthinformation;
//import com.example.ceramicjbw.repository.CategoryHealthinformationRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class CategoryHealthInformation implements iCategoryHealthInformation{
//
//    @Autowired
//    private final CategoryHealthinformationRepository categoryHealthinformationRepository;
//
//
//    @Override
//    public CategoryHealthinformation getCategoryHealthinformationById(Long id) throws Exception {
//        return categoryHealthinformationRepository
//                .findById(id)
//                .orElseThrow(() -> new Exception("Không tìm thấy Chuyên mục Thông tin sức khỏe với ID : " + id));
//    }
//
//    @Override
//    public List<CategoryHealthinformation> getAllCategoryHealthinformation(){
//        return categoryHealthinformationRepository.findAll();
//    }
//}
