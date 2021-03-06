//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo.beans;

public class AnswerDetailsVoBean extends ims.vo.ValueObjectBean
{
	public AnswerDetailsVoBean()
	{
	}
	public AnswerDetailsVoBean(ims.core.vo.AnswerDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.answertype = vo.getAnswerType() == null ? null : (ims.core.vo.beans.QuestionAnswerTypeVoBean)vo.getAnswerType().getBean();
		this.multiselectanswers = vo.getMultiSelectAnswers() == null ? null : vo.getMultiSelectAnswers().getBeanCollection();
		this.picklist = vo.getPicklist() == null ? null : (ims.core.vo.beans.AnswerOptionVoBean)vo.getPicklist().getBean();
		this.calculatedscore = vo.getCalculatedScore();
		this.boolvalueanswer = vo.getBoolValueAnswer();
		this.dateanswer = vo.getDateAnswer() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateAnswer().getBean();
		this.timeanswer = vo.getTimeAnswer() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeAnswer().getBean();
		this.stringanswer = vo.getStringAnswer();
		this.integeranswer = vo.getIntegerAnswer();
		this.decimalanswer = vo.getDecimalAnswer();
		this.partialdate = vo.getPartialDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getPartialDate().getBean();
		this.maxmultiselectallowed = vo.getMaxMultiselectAllowed();
		this.answerwidth = vo.getAnswerWidth();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.AnswerDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.answertype = vo.getAnswerType() == null ? null : (ims.core.vo.beans.QuestionAnswerTypeVoBean)vo.getAnswerType().getBean(map);
		this.multiselectanswers = vo.getMultiSelectAnswers() == null ? null : vo.getMultiSelectAnswers().getBeanCollection();
		this.picklist = vo.getPicklist() == null ? null : (ims.core.vo.beans.AnswerOptionVoBean)vo.getPicklist().getBean(map);
		this.calculatedscore = vo.getCalculatedScore();
		this.boolvalueanswer = vo.getBoolValueAnswer();
		this.dateanswer = vo.getDateAnswer() == null ? null : (ims.framework.utils.beans.DateBean)vo.getDateAnswer().getBean();
		this.timeanswer = vo.getTimeAnswer() == null ? null : (ims.framework.utils.beans.TimeBean)vo.getTimeAnswer().getBean();
		this.stringanswer = vo.getStringAnswer();
		this.integeranswer = vo.getIntegerAnswer();
		this.decimalanswer = vo.getDecimalAnswer();
		this.partialdate = vo.getPartialDate() == null ? null : (ims.framework.utils.beans.PartialDateBean)vo.getPartialDate().getBean();
		this.maxmultiselectallowed = vo.getMaxMultiselectAllowed();
		this.answerwidth = vo.getAnswerWidth();
	}

	public ims.core.vo.AnswerDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.core.vo.AnswerDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.AnswerDetailsVo vo = null;
		if(map != null)
			vo = (ims.core.vo.AnswerDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.core.vo.AnswerDetailsVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.core.vo.beans.QuestionAnswerTypeVoBean getAnswerType()
	{
		return this.answertype;
	}
	public void setAnswerType(ims.core.vo.beans.QuestionAnswerTypeVoBean value)
	{
		this.answertype = value;
	}
	public ims.core.vo.beans.AnswerOptionVoBean[] getMultiSelectAnswers()
	{
		return this.multiselectanswers;
	}
	public void setMultiSelectAnswers(ims.core.vo.beans.AnswerOptionVoBean[] value)
	{
		this.multiselectanswers = value;
	}
	public ims.core.vo.beans.AnswerOptionVoBean getPicklist()
	{
		return this.picklist;
	}
	public void setPicklist(ims.core.vo.beans.AnswerOptionVoBean value)
	{
		this.picklist = value;
	}
	public Float getCalculatedScore()
	{
		return this.calculatedscore;
	}
	public void setCalculatedScore(Float value)
	{
		this.calculatedscore = value;
	}
	public Boolean getBoolValueAnswer()
	{
		return this.boolvalueanswer;
	}
	public void setBoolValueAnswer(Boolean value)
	{
		this.boolvalueanswer = value;
	}
	public ims.framework.utils.beans.DateBean getDateAnswer()
	{
		return this.dateanswer;
	}
	public void setDateAnswer(ims.framework.utils.beans.DateBean value)
	{
		this.dateanswer = value;
	}
	public ims.framework.utils.beans.TimeBean getTimeAnswer()
	{
		return this.timeanswer;
	}
	public void setTimeAnswer(ims.framework.utils.beans.TimeBean value)
	{
		this.timeanswer = value;
	}
	public String getStringAnswer()
	{
		return this.stringanswer;
	}
	public void setStringAnswer(String value)
	{
		this.stringanswer = value;
	}
	public Integer getIntegerAnswer()
	{
		return this.integeranswer;
	}
	public void setIntegerAnswer(Integer value)
	{
		this.integeranswer = value;
	}
	public Float getDecimalAnswer()
	{
		return this.decimalanswer;
	}
	public void setDecimalAnswer(Float value)
	{
		this.decimalanswer = value;
	}
	public ims.framework.utils.beans.PartialDateBean getPartialDate()
	{
		return this.partialdate;
	}
	public void setPartialDate(ims.framework.utils.beans.PartialDateBean value)
	{
		this.partialdate = value;
	}
	public Integer getMaxMultiselectAllowed()
	{
		return this.maxmultiselectallowed;
	}
	public void setMaxMultiselectAllowed(Integer value)
	{
		this.maxmultiselectallowed = value;
	}
	public Integer getAnswerWidth()
	{
		return this.answerwidth;
	}
	public void setAnswerWidth(Integer value)
	{
		this.answerwidth = value;
	}

	private Integer id;
	private int version;
	private ims.core.vo.beans.QuestionAnswerTypeVoBean answertype;
	private ims.core.vo.beans.AnswerOptionVoBean[] multiselectanswers;
	private ims.core.vo.beans.AnswerOptionVoBean picklist;
	private Float calculatedscore;
	private Boolean boolvalueanswer;
	private ims.framework.utils.beans.DateBean dateanswer;
	private ims.framework.utils.beans.TimeBean timeanswer;
	private String stringanswer;
	private Integer integeranswer;
	private Float decimalanswer;
	private ims.framework.utils.beans.PartialDateBean partialdate;
	private Integer maxmultiselectallowed;
	private Integer answerwidth;
}
