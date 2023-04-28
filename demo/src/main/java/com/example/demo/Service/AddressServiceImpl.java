package com.example.demo.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Exception.Exception;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository AddressRepository;
    private final ModelMapper mapper;
    @Override
    public List<AddressDto> getallAddress() throws Exception{
        List<Address> AddressList = AddressRepository.findAll(); //  1 mảng Address
        List<AddressDto> AddressDtoList = new ArrayList<>();  //  1 mảng AddressDto trống
        for(Address i : AddressList){ // map từng phần tử Address thành AddressDto
            AddressDto x = mapper.map(i,AddressDto.class);
            AddressDtoList.add(x);                         // thêm vào mảng trống
        }
        return AddressDtoList;
    }


}
