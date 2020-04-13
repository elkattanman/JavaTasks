/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author elkat
 */
public interface DAO {
    public void insert(Object o);
    public List<Object> getAll();
    public void update(Object o);
    public void delete(Object o);
}
