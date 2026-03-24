package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.vo.ProductVO;

public class ProductDAO {
   
   public SqlSession sqlSession;
   
   public ProductDAO() {
//      openSession(autoCommit)
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
//   상품 추가
   public void insert(ProductVO productVO) {
      sqlSession.insert("product.insert", productVO);
   }
   
//   상품 전체조회
   public List<ProductVO> selectAll() {
      List<ProductVO> products = sqlSession.selectList("product.selectAll");
      return products;
   }
//   상품 단일조회
   public Optional<ProductVO> select(Long id) {
	   ProductVO product = sqlSession.selectOne("product.select", id);
	   return Optional.ofNullable(product);
   }
//   상품 수정
   public void update(ProductVO productVO) {
	   sqlSession.update("product.update", productVO);
   }
//   상품 삭제
   public void delete(Long id) {
	   sqlSession.delete("product.delete", id);
   }
   
}




